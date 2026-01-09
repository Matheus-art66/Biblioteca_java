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
        senha: senha,
        cpf: document.querySelector('input[name="cpf"]').value
    };

    // 👉 só adiciona perfil se existir no HTML
    if (selectPerfil) {
        dados.perfil = selectPerfil.value;
    }""
    // se não existir, o banco assume CLIENTE

    fetch("/cadastrar", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(dados)
    })
        .then(resp => resp.json())
        .then(data => {
            alert("Usuário cadastrado com sucesso!");
        })
        .catch(err => console.error(err));
});
