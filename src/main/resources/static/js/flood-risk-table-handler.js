function init() {
	const regionSelect = document.getElementById('region-select');
	regionSelect.addEventListener("change", () => filterDatesByRegion());
	filterDatesByRegion();
}

function filterDatesByRegion() {
	const regionSelect = document.getElementById('region-select');
	const dateSelect = document.getElementById('date-select');
	const selectedRegion = regionSelect.value;
	const disabledOption = dateSelect.querySelector('option[disabled]');

	// Get all options from the server-rendered list
	const allOptions = Array.from(document.querySelectorAll('#date-select option[data-region-name]'));

	// Filter options based on selected region
	const filteredOptions = allOptions.filter(option => option.getAttribute('data-region-name').toLowerCase() === selectedRegion);
	allOptions.forEach((option) => option.classList.add("hidden"));

	// Append filtered options to the date select element
	if (filteredOptions.length > 0) {
		dateSelect.disabled = false;
		disabledOption.classList.add("hidden");
		filteredOptions.forEach(option => option.classList.remove("hidden"));
		filteredOptions[0].selected = true;
	} else {
		dateSelect.disabled = true;
		disabledOption.selected = true;
		disabledOption.classList.remove("hidden");
	}
}

export { init, filterDatesByRegion };
