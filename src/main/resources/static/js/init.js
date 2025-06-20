document.addEventListener("DOMContentLoaded", init);

function init() {
	const pageType = document.body.dataset.page;

	if (pageType === "index") {
		import("./flood-risk-table-handler.js").then(module => {
			module.init();
		});

		// import("./data-chart-renderer.js").then(module => {
		// 	module.init();
		// });
	}
}
