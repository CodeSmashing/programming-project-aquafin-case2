function init() {
	// Select table and menu elements
	const tableFloodRisk = document.querySelector("#flood-risk-table");
	const menuRow = tableFloodRisk.querySelector("thead #menu-row");
	const tableRowList = Array.from(tableFloodRisk.querySelectorAll("tbody tr:not(.table-end)"));
	const regionSelect = menuRow.querySelector("#region-select");
	const dateSelect = menuRow.querySelector("#date-select");
	const filterHistoric = menuRow.querySelector("#filter-historic");
	const filterForecast = menuRow.querySelector("#filter-forecast");
	const filterResults = menuRow.querySelector("#filter-results");
	// const graphicalView = menuRow.querySelector("#graphical-view");
	const tableEndUnavailable = tableFloodRisk.querySelector("tbody tr.table-end.table-end-unavailable");
	const tableEndHidden = tableFloodRisk.querySelector("tbody tr.table-end.table-end-hidden");
	const filterOptionList = {
		historic: false,
		forecast: false,
		results: false,
	};

	const filterOptionListOpposites = {
		historic: "forecast",
		forecast: "historic",
	};

	// Helper functions to get selected region and date
	const getRegion = () => regionSelect.value;
	const getDate = () => dateSelect.value;

	// Reorder rows in the table based on the filtered list
	const reorderTable = (rowList) => {
		const firstRow = tableFloodRisk.querySelector("tbody tr");
		rowList.forEach(row => firstRow.parentNode.insertBefore(row, firstRow));
	};

	// Filter table based on the selected rule
	const filterTable = () => {
		tableRowList.forEach(row => {
			const matchesRegion = Array.from(row.querySelectorAll("td")).some(cell => cell.matches(`td[data-name="${getRegion()}"]`));
			const matchesDate = Array.from(row.querySelectorAll("td")).some(cell => cell.matches(`td[data-name="${getRegion()}"] ~ td[data-date="${getDate()}"]`));
			const isHistoric = Array.from(row.querySelectorAll("td")).some(cell => cell.matches(`td[data-type="0"]`));
			const isForecast = Array.from(row.querySelectorAll("td")).some(cell => cell.matches(`td[data-type="1"]`));

			let shouldFilter = false;

			// Apply region and date filters
			if (!matchesRegion && (getRegion() !== "all")) {
				shouldFilter = true;
			}
			if (!matchesDate && (getDate() !== "all")) {
				shouldFilter = true;
			}

			// Apply historic/forecast filters
			if (filterOptionList.historic && !isHistoric) {
				shouldFilter = true;
			} else if (filterOptionList.forecast && !isForecast) {
				shouldFilter = true;
			}

			// Apply results filter
			if (filterOptionList.results && shouldFilter) {
				row.classList.add("hidden");
			} else {
				row.classList.remove("hidden");
			}

			row.classList.toggle("filtered", shouldFilter);
		});

		reorderTable(tableRowList.filter(row => !row.classList.contains("filtered")));

		if (tableRowList.every(row => row.classList.contains("hidden"))) {
			tableEndUnavailable.classList.remove("hidden");
			tableEndHidden.classList.add("hidden");
		} else {
			tableEndUnavailable.classList.add("hidden");
		}

		if (tableEndUnavailable.classList.contains("hidden") && tableRowList.some(row => row.classList.contains("hidden"))) {
			tableEndHidden.classList.remove("hidden");
		} else {
			tableEndHidden.classList.add("hidden");
		}
	};

	// Toggle filter options for historic, forecast, and results
	const toggleFilterOption = (option) => {
		const filterButton = menuRow.querySelector(`#filter-${option}`);
		const oppositeOption = filterOptionListOpposites[option];
		const filterButtonOpposite = menuRow.querySelector(`#filter-${oppositeOption}`);

		// Toggle the current option
		filterOptionList[option] = !filterOptionList[option];
		filterButton.classList.toggle("active");

		// Disable the opposite option if active
		if (filterOptionList[oppositeOption]) {
			filterOptionList[oppositeOption] = false;
			filterButtonOpposite.classList.remove("active");
		}

		filterTable();
	};

	// Toggle graphical view (placeholder functionality)
	const toggleGraphicalView = () => {
		console.log("Graphical view toggled", tableFloodRisk);
	};

	// Add a new flood risk entry (placeholder functionality)
	const addNewFloodRisk = () => {
		console.log("Add new flood risk entry", tableFloodRisk);
	};

	// Filter dates based on the selected region
	const filterDatesByRegion = () => {
		const selectedRegion = getRegion();
		const disabledOption = dateSelect.querySelector("option[disabled]");
		const allOption = dateSelect.querySelector("option[value='all']");
		const optionList = Array.from(dateSelect.querySelectorAll(":not([disabled])")).filter(option => option.value !== "all");

		// If there are no options available
		if (optionList.length === 0) {
			dateSelect.disabled = true;
			disabledOption.selected = true;
			disabledOption.classList.remove("hidden");
			return;
		}

		// Search options based on the selected region
		const searchedOptions = optionList.filter(option => option.dataset.name === selectedRegion);
		optionList.forEach(option => option.classList.add("hidden"));

		if (searchedOptions.length > 0) {
			dateSelect.disabled = false;
			disabledOption.classList.add("hidden");
			searchedOptions.forEach((option) => option.classList.remove("hidden"));
			allOption.selected = true;
		} else {
			dateSelect.disabled = true;
			disabledOption.selected = true;
			disabledOption.classList.remove("hidden");
		}
	};

	// Selectors
	regionSelect.addEventListener("change", () => {
		filterDatesByRegion();
		filterTable();
	});
	dateSelect.addEventListener("change", () => filterTable());

	// Buttons
	filterHistoric.addEventListener("click", () => toggleFilterOption("historic"));
	filterForecast.addEventListener("click", () => toggleFilterOption("forecast"));
	filterResults.addEventListener("click", () => toggleFilterOption("results"));
	// graphicalView.addEventListener("click", toggleGraphicalView);

	// Other
	tableEndHidden.querySelector("button").addEventListener("click", () => toggleFilterOption("results"));
	regionSelect.dispatchEvent(new Event("change"));
}

export { init };
