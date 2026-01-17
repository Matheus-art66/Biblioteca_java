document.getElementById("formBuscarLivro").addEventListener("submit", function (e) {
    e.preventDefault();

    const titulo = document.querySelector('input[name="titulo"]').value;
    const categoria = document.querySelector('select[name="categoria"]').value;

    const params = new URLSearchParams();

    if (titulo) {
        params.append("titulo", titulo);
    }

    if (categoria) {
        params.append("categoria", categoria);
    }

    fetch("/buscar?" + params.toString())
        .then(res => res.json())
        .then(livros => {
            const tbody = document.getElementById("tabelaLivros");
            tbody.innerHTML = ""; // limpa a tabela

            let linhas = "";

            livros.forEach(livro => {
                linhas += `
                    <tr>
                        <td>${livro.codigo}</td>
                        <td>${livro.titulo}</td>
                        <td>${livro.autor}</td>
                        <td>${livro.categoria}</td>
                        <td>
                            <form action="/emprestimo/realizar" method="post">
                                <input type="hidden" name="codigoLivro" value="${livro.codigo}">
                                <button type="submit" class="btn-emprestar">
                                    Emprestar
                                </button>
                            </form>
                        </td>
                    </tr>
                `;
            });

            tbody.innerHTML = linhas;
        })
        .catch(err => console.error(err));
});
