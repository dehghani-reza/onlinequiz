$(document).ready(function () {

    $("#loginForm").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        event.stopPropagation();

        let loginFormClass = document.getElementById("loginForm").getAttribute('class');

        if(loginFormClass.includes('was-validated')){
            loginToAccount();
        }
    });

});

function loginToAccount() {
    const username = $("#username").val();
    const password = $("#password").val();

    const LoginToAccountByUserCommand = {
        "username": username,
        "password": password
    };

    $.ajax({
        url: "http://localhost:7777/login",
        type: "POST",
        data: JSON.stringify(LoginToAccountByUserCommand),
        headers: {
            "Authorization": "Basic " + btoa(username + ":" + password)
        },
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            console.log("success")
            // let guest = false;
            //
            // for (let i = 0; i < data.roles.length; i++) {
            //     if (data.roles[i].roleType === "ROLE_GUEST") {
            //         guest = true;
            //         break;
            //     }
            // }
            //
            // if (guest) {
            //     location.replace("https://www.guest.com")
            // } else {
            //     for (let i = 0; i < data.roles.length; i++) {
            //         if (data.roles[i].roleType === "ROLE_STUDENT") {
            //             location.replace("https://www.student.com")
            //         }
            //         if (data.roles[i].roleType === "ROLE_TEACHER") {
            //             location.replace("https://www.teacher.com")
            //         }
            //         if (data.roles[i].roleType === "ROLE_MANAGER") {
            //             location.replace("https://www.manager.com")
            //         }
            //     }
            // }
        },
        error: function (errorMessage) {
            showAlert("danger", 'اطلاعات وارد شده صحیح نمی باشد');
        }
    });
}


