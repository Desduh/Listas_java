import '../style.css';
import Header from '../../components/Header';
import Title from '../../components/Title';

import { Link } from 'react-router-dom';
import { FiPlus } from "react-icons/fi";


export default function Cadastrar() {
    return (
        <div>
            <Header />

            <div className="content">
                <Title name="Cadastrar">
                    <FiPlus color="#8b8da5" size={25} />
                </Title>

                <div className='table-cadastro'>
                <table>
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <Link className="cadastrar" to={`/cliente`}>
                                Cliente </Link>
                            </td>
                            <td>
                                <Link className="cadastrar" to={`/empresa`}>
                                Empresa </Link>
                            </td>
                            <td>
                                <Link className="cadastrar" to={`/veiculo`}>
                                Veículo </Link>
                            </td>
                            <td>
                                <Link className="cadastrar" to={`/servico`}>
                                Serviço </Link>
                            </td>
                            <td>
                                <Link className="cadastrar" to={`/mercadoria`}>
                                Mercadoria </Link>
                            </td>
                            <td>
                                <Link className="cadastrar" to={`/venda`}>
                                Venda </Link>
                            </td>
                        </tr>
                    </tbody>
                </table>
                </div>

            </div>
        </div>
    )
}