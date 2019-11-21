import Axios from 'axios';

export default function serviceRegisterRequest() {

    const name = document.getElementById("txtName").value;
    const price = document.getElementById("txtPrice").value;
    const description = document.getElementById("txtDescription").value;
    const time = document.getElementById("txtTime").value;

    const params = [
        { name, price, description, time }
    ]

    Axios.post('https://reqres.in/api/users', params)
        .then(Response => {
            console.log(Response)
        })
        .catch(Error => {
            console.log(Error)
        })
}