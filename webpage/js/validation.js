const inputs = document.querySelectorAll('input');

const patterns = {
    name: /^(.|\s)*\S(.|\s)*$/,
    telephone: /^\d{10}$/,
    email: /^([a-z\d\.-]+)@([a-z\d-]+)\.([a-z]{2,8})(\.[a-z]{2,8})?$/,
    //message: /^[a-z]{1,250}$/i
}

function validate(field, regex){

    if(regex.test(field.value)){
        field.className = 'valid';
    } else {
        field.className = 'invalid';
    }

}

inputs.forEach((input) => {
    input.addEventListener('keyup', (e) => {
        validate(e.target, patterns[e.target.attributes.name.value]);
    });
});