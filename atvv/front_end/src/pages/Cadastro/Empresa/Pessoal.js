import { useState } from "react";
import { Link } from 'react-router-dom';
import { IMaskInput } from "react-imask";

import { toast } from 'react-toastify';
import { FiPlusCircle } from "react-icons/fi";

export default function Pessoal({ onButtonClick }) {
  const [razaoSocial, setRazaoSocial] = useState('');
  const [nomeFantasia, setNomeFantasia] = useState('');
  const [dataCadastro, setDataCadastro] = useState('');
  
  const [telefone, setTelefone] = useState('');
  const [telefones, setTelefones] = useState([]);

  // -----------------------------------------------------

  function addTelefone() {
    let telefoninho = {
      telefone: telefone
    };
    setTelefone('')
    setTelefones((prevTelefones) => [...prevTelefones, telefoninho]);
    toast.success('Telefone adicionado!');
  }

  // -----------------------------------------------------

  function handleSubmit() {
    onButtonClick("pagetwo");
  }

  return (
    <div className="container">
      <form className="forms" onSubmit={handleSubmit}>
        <label id="stepTitle">Cadastro</label>

        <input type="text" placeholder="Razão social" value={razaoSocial}
          onChange={(e) => setRazaoSocial(e.target.value)} />

        <input type="text" placeholder="Nome fantasia" value={nomeFantasia}
          onChange={(e) => setNomeFantasia(e.target.value)} />

        <span>Data de cadastro</span>
        <input type="date" value={dataCadastro}
          onChange={(e) => setDataCadastro(e.target.value)} />

        <IMaskInput mask="(00) 00000-0000" placeholder='Telefone' value={telefone}
          onChange={e => setTelefone(e.target.value)} />
              
        <div className="plus">
          <Link onClick={() => addTelefone()}>
            <FiPlusCircle color="#000" size={25} />
          </Link>
        </div>

        <button className="submit" onClick={() => handleSubmit()}>
          Próximo</button>
      </form>
    </div>
  )
}