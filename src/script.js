const API = "http://localhost:8081";

    function showSection(id) {
        document.querySelectorAll(".section").forEach(sec => sec.classList.remove("active"));
        document.getElementById(id).classList.add("active");
    }

   document.getElementById("formCadastro").addEventListener("submit", async (e) => {
       e.preventDefault();

       const data = {
           name: document.getElementById("name").value,
           birthDate: document.getElementById("birthDate").value,
           phone: document.getElementById("phone").value,
           hireDate: document.getElementById("hireDate").value,
           role: document.getElementById("cargo").value,
           cpf: document.getElementById("cpf").value
       };

       const res = await fetch(`${API}/employee`, {
           method: "POST",
           headers: {"Content-Type": "application/json"},
           body: JSON.stringify(data)
       });

       const msg = document.getElementById("msgCadastro");

       if (res.ok) {
           msg.textContent = "Funcionário cadastrado!";
           msg.style.color = "green";
           e.target.reset();
       } else {
           msg.textContent = "Erro ao cadastrar.";
           msg.style.color = "red";
       }
   });

function preencherTabela(funcionarios) {
    const tbody = document.querySelector("#tabela tbody");
    tbody.innerHTML = "";

    funcionarios.forEach(f => {
        tbody.innerHTML += `
            <tr>
                <td>${f.id}</td>
                <td>${f.name}</td>
                <td>${f.role}</td>
                <td>${f.hireDate}</td>
                <td>
                    <button class="action-btn edit" onclick="editar(${f.id})">Editar</button>
                    <button class="action-btn delete" onclick="excluir(${f.id})">Excluir</button>
                </td>
            </tr>
        `;
    });
}

async function buscarNome() {
    const nome = document.getElementById("buscaNome").value.trim();
    if (!nome) return alert("Digite um nome para buscar");
    buscar(`${API}/employee/name?name=${encodeURIComponent(nome)}`);
}

async function buscarCargo() {
    const cargo = document.getElementById("buscaCargo").value;
    if (!cargo) return alert("Selecione um cargo para buscar");
    buscar(`${API}/employee/role/${encodeURIComponent(cargo)}`);
}

async function buscarId() {
    const id = document.getElementById("buscaId").value.trim();
    if (!id) return alert("Digite um ID válido");
    buscar(`${API}/employee/${encodeURIComponent(id)}`);
}

async function listarTodos() {
    buscar(`${API}/employee`);
}


async function buscar(url) {
    try {
        const res = await fetch(url);
        const msg = document.getElementById("msgBusca");

        if (!res.ok) {
            msg.textContent = "Nenhum registro encontrado.";
            msg.style.color = "red";
            const tbody = document.querySelector("#tabela tbody");
            tbody.innerHTML = "";
            return;
        }

        const data = await res.json();
        msg.textContent = "";
        preencherTabela(Array.isArray(data) ? data : [data]);
    } catch (err) {
        console.error(err);
        document.getElementById("msgBusca").textContent = "Erro na busca.";
    }
}

    async function excluir(id) {
        if (!confirm("Deseja excluir este funcionário?")) return;
        await fetch(`${API}/employee/${id}`, { method: "DELETE" });
        listarTodos();
    }


    async function editar(id) {
        const nome = prompt("Novo nome:");
        const cargo = prompt("Novo cargo:");
        const data = prompt("Nova data (yyyy-MM-dd):");

        const body = { name: nome, role: cargo, hireDate: data };

        await fetch(`${API}/employee/${id}`, {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(body)
        });

        listarTodos();
    }


    function exportPDF() {
        window.open(`${API}/employees/pdf`, "_blank");
    }