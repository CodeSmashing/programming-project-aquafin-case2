document.addEventListener("DOMContentLoaded", init);

function init() {
	const pageType = document.body.dataset.page;

	if (pageType === 'home') {

	} else if (pageType === 'data-raw') {
		import('./data-chart-renderer.js').then(module => {
			module.init();
		});
	}
}
