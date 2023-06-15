import { useState } from "react";
import { IMaskInput } from "react-imask";

export default function Pessoal({ onButtonClick }) {   
    const [nomeCliente, setNomeCliente] = useState('');
    const [nomeSocial, setNomeSocial] = useState('');
    const [dataNasc, setDataNasc] = useState('');
    const [dataCadastro, setDataCadastro] = useState('');

    function handleSubmit() {
      onButtonClick("pagetwo");
    }      

    return (
        <div className="container">
          <form className="forms" onSubmit={handleSubmit}>
            <label id="stepTitle">Cadastro</label>
            
            <input type="text" placeholder="Nome" value={nomeCliente} 
            onChange={ (e) => setNomeCliente(e.target.value) } />

            <input type="text" placeholder="Nome social" value={nomeSocial} 
            onChange={ (e) => setNomeSocial(e.target.value) } />

            <span>Data de nascimento</span>
            <input type="date" value={dataNasc} 
            onChange={ (e) => setDataNasc(e.target.value) } />
            
            <span>Data de cadastro</span>
            <input type="date"value={dataCadastro} 
            onChange={ (e) => setDataCadastro(e.target.value) } />
            
            <button className="submit" onClick={() => handleSubmit()}>
                Próximo</button>
          </form>
        </div>
    )
}