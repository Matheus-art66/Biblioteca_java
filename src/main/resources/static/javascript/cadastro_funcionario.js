document.getElementById("formCadastroFuncionario").addEventListener("submit",function(e){
    e.preventDefault();

    const senha = document.querySelector('input[name="senha"]').value;
    const confirmarSenha = document.querySelector('input[name="confirmarSenha"]').value;

    if(senha !== confirmarSenha){
        window.alert("As senhas precisam ser iguais!")
        return;
    }
    
    
    const dados ={
        nome:document.querySelector('input[name="nome"]').value,
        email:document.querySelector('input[name="email"]').value,
        cpf:document.querySelector('input[name="cpf"]').value,
        senha:senha,
        cargo:document.querySelector('input[name="cargo"]').value,
        perfil: document.querySelector('input[name="perfil"]').value,
        ativo: document.querySelector('input[name="ativo"]').checked
    }

    fetch("/funcionario",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(dados)
    }).then(resp=> resp.json())
    .then(data => {
        window.alert("Usuario cadastrado com sucesso!")
    })
    .catch(err => console.error(err));
})