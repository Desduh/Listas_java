import { useState } from "react";
import { Link } from 'react-router-dom';
import { IMaskInput } from "react-imask";

import { toast } from 'react-toastify';
import { FiPlusCircle } from "react-icons/fi";

export default function Documentos({ onButtonClick }) {
  const [tipo, setTipo] = useState('');
  const [numero, setNumero] = useState('');
  const [dataEmissao, setDataEmissao] = useState('');
  const [documentos, setDocumentos] = useState([]);
  
  const [telefone, setTelefone] = useState('');
  const [telefones, setTelefones] = useState([]);
  
  function addDocumento() {
    let documentinho = {
      tipo: tipo,
      numero: numero
    };
    setTipo('')
    setNumero('')
    setDocumentos((prevDocumentos) => [...prevDocumentos, documentinho]);
    toast.success('Documento adicionado!');
  }

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
    onButtonClick("pagethree");
  }

  function handleReturn(e) {
    return onButtonClick("pageone")
  }

  return (
    <div className="container">
      <form className="forms" onSubmit={handleSubmit}>
        <label id="stepTitle">Documento</label>

        <select onChange={e => setTipo(e.target.value)}>
          <option value="CPF">CPF</option>
          <option value="CNPJ">CNPJ</option>
          <option value="RG">RG</option>
          <option value="CNH">CNH</option>
          <option value="Passaporte">Passaporte</option>
        </select>

        <input type="text" placeholder="Número" value={numero}
          onChange={(e) => setNumero(e.target.value)} />

        <span>Data de emissão</span>
        <input type="date" value={dataEmissao}
          onChange={(e) => setDataEmissao(e.target.value)} />

        <div className="plus">
          <Link onClick={() => addDocumento()}>
            <FiPlusCircle color="#000" size={25} />
          </Link>
        </div>

        {/* --------------------------------------------- */}

        <IMaskInput mask="(00) 00000-0000" placeholder='Telefone' value={telefone}
          onChange={e => setTelefone(e.target.value)} />
              
        <div className="plus">
          <Link onClick={() => addTelefone()}>
            <FiPlusCircle color="#000" size={25} />
          </Link>
        </div>

        <div className="BackNext">
          <button className="submit" onClick={() => handleReturn()}>
            Voltar</button>

          <button className="submit" onClick={() => handleSubmit()}>
            Próximo</button>
        </div>
      </form>
    </div>
  )
}