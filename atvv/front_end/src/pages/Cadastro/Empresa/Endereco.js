import { useState } from "react";
import { toast } from 'react-toastify';
import { IMaskInput } from "react-imask";

export default function Endereco({ onButtonClick }) {

  const [cep, setCep] = useState('');
  const [logradouro, setLogradouro] = useState('');
  const [numero, setNumero] = useState('');
  const [bairro, setBairro] = useState('');
  const [cidade, setCidade] = useState('');
  const [estado, setEstado] = useState('');
  const [complemento, setComplemento] = useState('');

  const checkCEP = (e) => {
    const cep = e.target.value.replace(/\D/g, '');
    fetch(`https://viacep.com.br/ws/${cep}/json/`).then(res => res.json()).then(data => {
      setLogradouro(data.logradouro);
      setBairro(data.bairro);
      setCidade(data.localidade);
      setEstado(data.uf);
    }).catch((err) => {
      toast.warning("CEP inválido")
      setLogradouro('');
      setBairro('');
      setCidade('');
      setEstado('');
    }
    )
  }

  function handleSubmit() {
    onButtonClick("pageone");
  }

  function handleReturn(e) {
    return onButtonClick("pagetwo")
  }

  return (
    <div className="container">
      <form className="forms" onSubmit={handleSubmit}>
        <label id="stepTitle">Endereço</label>

        <IMaskInput mask="00.000-000" placeholder='CEP' maxLength="11" value={cep} onBlur={checkCEP}
          onChange={(e) => setCep(e.target.value)} />

        <input type='text' placeholder='Logradouro' value={logradouro}
          onChange={(e) => setLogradouro(e.target.value)} />

        <input type="number" placeholder='Número' value={numero}
          onChange={(e) => setNumero(e.target.value)} />

        <input type="text" placeholder='Bairro' value={bairro}
          onChange={(e) => setBairro(e.target.value)} />

        <input type="text" placeholder='Cidade' value={cidade}
          onChange={(e) => setCidade(e.target.value)} />

        <input type="text" placeholder='Estado' maxLength='2' value={estado}
          onChange={(e) => setEstado(e.target.value)} />

        <input type="text" placeholder='Complemento' value={complemento}
          onChange={(e) => setComplemento(e.target.value)} />

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