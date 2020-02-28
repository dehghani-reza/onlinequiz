function showPassword() {
    const x = document.getElementById("password");
    if (x.type === "password") {
        x.type = "text";
        document.getElementById("passIcon").setAttribute("class", "fa fa-eye");
    } else {
        x.type = "password";
        document.getElementById("passIcon").setAttribute("class", "fa fa-eye-slash");
    }
}
