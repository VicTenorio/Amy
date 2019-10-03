


module.exports = class Maps {
    constructor(_email,_senha) {
        this.email = _email;
        this.senha = _senha;
    }

    
    save() {
        var usuario = [
            {
              email: this.email, 
              senha: this.senha
            },
            {
              email: "teste@2",
              senha: "senha123"
            },
            {
              email: "teste@3", 
              senha: "senha123"
            }
        ];
        return JSON.stringify(usuario);
    }

    save2() {
        console.log("Teste");
    }
}