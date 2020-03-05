function showConfirmPassword() {
    const x = document.getElementById("confirmPassword");
    if (x.type === "password") {
        x.type = "text";
        document.getElementById("confPassIcon").setAttribute("class", "fa fa-eye");
    } else {
        x.type = "password";
        document.getElementById("confPassIcon").setAttribute("class", "fa fa-eye-slash");
    }
}

$(document).ready(function () {
    $("#confirmPassword").focusout(function () {
        const password = $("#password").val();
        const confirmPassword = $("#confirmPassword").val();
        if (password !== confirmPassword) {
            alert("رمز عبور با رمز عبور تایید شده مطابقت ندارد !");
        }
    });
});

$(document).ready(function () {

    $("#registerForm").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        event.stopPropagation();

        let username = $("#username").val();
        let password = $("#password").val();
        let conf = $("#confirmPassword").val();
        let role = $('#role option:selected').val();

        if ($('#invalidCheck').is(":checked")
            && username !== ''
            && password !== ''
            && conf !== ''
            && role !== ''
        ) {
            register();
        }


    });

});

function register() {
    const registerAccountByGuestCommand = {
        "username": $("#username").val(),
        "password": $("#password").val(),
        "role": $('#role option:selected').val()
    };

    $.ajax({
        url: serverUrl() + "/user/register",
        type: "POST",
        data: JSON.stringify(registerAccountByGuestCommand),
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            showAlert('success', 'اطلاغات شما با موفقیت ثبت گردید. لطفا وارد شوید');
        },
        error: function (errorMessage) {
            showAlert('danger', errorMessage.responseJSON.message);
        }
    })
}
