import axios from 'axios';

export default function login (){
const params = {
    "email": document.getElementById('user-input').value,
    "senha": document.getElementById('password-input').value
}

    axios.post('http://localhost:3001/usuario/login', params)
        .then(function (response){
        
        }
        )
        .catch(function (error) {
            console.log(error);
    })
      
    
}

