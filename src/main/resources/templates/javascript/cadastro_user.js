document.getElementById("formCadastro").addEventListener("submit",function(e){
    e.preventDefault();

    const dados={
        nomeUsuario: document.querySelector('input[name="nome"]').value,
        email:document.querySelector('input[name="email"]').value,
        senha
    }
})