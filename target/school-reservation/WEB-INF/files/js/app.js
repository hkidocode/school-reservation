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


// Set current date in input of type date
function getDate(){
    let today = new Date();
    const inputDates = document.querySelectorAll("input[type='date']");
    inputDates.forEach(inputDate => {
        inputDate.value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);
    });
}

document.addEventListener('DOMContentLoaded', () => {
    setupTabs();
    getDate();
});

const addRsv = document.querySelector('.add-rsv');
if (addRsv.hidden) {
    addRsv.hidden = false;
    addRsv.style.display = "none";
}
