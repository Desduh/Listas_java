import { useState } from "react";

import Header from '../../../components/Header';
import Title from '../../../components/Title';

import { Link } from 'react-router-dom';
import { IMaskInput } from "react-imask";

import { toast } from 'react-toastify';
import { FiClipboard } from "react-icons/fi";

export default function CadastrarServico() {
  const [nome, setNome] = useState('');
  const [valor, setValor] = useState('');
  const [descricao, setDescricao] = useState('');

  // -----------------------------------------------------

  function handleSubmit() {

  }

  return (
      <><Header />
      
      <div className="content">
      <Title name="Serviço">
        <FiClipboard color="#8b8da5" size={25} />
      </Title>

      <form className="forms" onSubmit={handleSubmit}>
        <label>Cadastro</label>

        <input type="text" placeholder="Nome" value={nome}
          onChange={(e) => setNome(e.target.value)} />

        <input type="text" placeholder="Valor" value={valor}
          onChange={(e) => setValor(e.target.value)} />

        <input type="text" placeholder="Descrição" value={descricao}
          onChange={(e) => setDescricao(e.target.value)} />

        <button className="submit" onClick={() => handleSubmit()}>
          Próximo</button>
      </form>
    </div></>
  )
}