$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
});
$('#app-content-load').load('/components/panels/guest/home/home.html');
function loadPage(page) {
    if (page === 'personal-information-form') {
        $('#app-content-load').load('/components/panels/guest/personal-information-form/personal-information-form.html');
    }

    if (page === 'home') {
        $('#app-content-load').load('/components/panels/guest/home/home.html');
    }
}


function getSecondPart(str) {
    return str.split('?')[1];
}
function getUsername(str) {
    return str.split(':')[0];
}

function getPassword(str) {
    return str.split(':')[1];
}

// use the function:
let url = getSecondPart(window.location.href);
let decrypt = atob(url);
let usernameHeader = getUsername(decrypt);
let passwordHeader = getPassword(decrypt);
