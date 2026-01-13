document.getElementById("formCadastro").addEventListener("submit", function (e) {
    e.preventDefault();

    const senha = document.querySelector('input[name="senha"]').value;
    const confsenha = document.querySelector('input[name="confsenha"]').value;

    if (senha !== confsenha) {
        alert("As senhas não conferem!");
        return;
    }

    const selectPerfil = document.querySelector('select[name="perfil"]');

    const dados = {
        nome: document.querySelector('input[name="nome"]').value,
        email: document.querySelector('input[name="email"]').value,
        cpf: document.querySelector('input[name="cpf"]').value,
        senha: senha
    };

    // adiciona perfil só se existir
    if (selectPerfil) {
        dados.perfil = selectPerfil.value;
    }

    fetch("/cadastrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dados)
    })
    .then(response => {
        if (response.status === 201) {
            // ✅ sucesso → redireciona
            window.location.href = "/busca";
        } else if (response.status === 400) {
            alert("Dados inválidos. Verifique o formulário.");
        } else if (response.status === 409) {
            alert("Usuário já cadastrado.");
        } else {
            alert("Erro inesperado ao cadastrar.");
        }
    })
    .catch(error => {
        console.error(error);
        alert("Erro de conexão com o servidor.");
    });
});
