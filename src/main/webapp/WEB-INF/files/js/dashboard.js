function setupTabs() {
    document.querySelectorAll('.tabs-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            const sidebar = btn.parentElement;
            const tabsContainer = sidebar.parentElement;
            const tabNumber = btn.dataset.forTab;
            const tabContentToActive = tabsContainer.querySelector(`.tabs-content[data-tab='${tabNumber}']`);

            sidebar.querySelectorAll('.tabs-btn').forEach(btn => {
                btn.classList.remove('tabs-btn-active');
            });

            tabsContainer.querySelectorAll('.tabs-content').forEach(tab => {
                tab.classList.remove('tabs-content-active');
            });

            btn.classList.add('tabs-btn-active');
            tabContentToActive.classList.add('tabs-content-active');
        });
    });
}

document.addEventListener('DOMContentLoaded', () => {
    setupTabs();
});
