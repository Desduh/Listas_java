import Header from '../../components/Header';
import Title from '../../components/Title';

import { Link } from 'react-router-dom';
import { FiHome, FiArrowRight } from "react-icons/fi";

export default function Dashboard(){
  return(
    <div>
      <Header/>

      <div className="content">
        <Title name="Início">
          <FiHome color="#8b8da5" size={25}/>
        </Title>

            <table>
              <thead>
                <tr>
                  <th scope="col">Listagem</th>
                  <th scope="col">Abrir</th>
                </tr>
              </thead>
              <tbody>
                    <tr>
                      <td data-label="Listagem">Clientes</td>
                      <td data-label="#">
                        <Link className="action" style={{backgroundColor: '#F6a935'}} to={`/listagem_clientes`}>
                          <FiArrowRight color="#fff" size={17}/>
                        </Link>
                      </td>
                    </tr>

                    <tr>
                      <td data-label="Listagem">Empresas</td>
                      <td data-label="#">
                        <Link className="action" style={{backgroundColor: '#F6a935'}} to={`/listagem_empresas`}>
                          <FiArrowRight color="#fff" size={17}/>
                        </Link>
                      </td>
                    </tr>

                    <tr>
                      <td data-label="Listagem">Veículos</td>
                      <td data-label="#">
                        <Link className="action" style={{backgroundColor: '#F6a935'}} to={`/listagem_clientes`}>
                          <FiArrowRight color="#fff" size={17}/>
                        </Link>
                      </td>
                    </tr>

                    <tr>
                      <td data-label="Listagem">Serviços</td>
                      <td data-label="#">
                        <Link className="action" style={{backgroundColor: '#F6a935'}} to={`/listagem_empresas`}>
                          <FiArrowRight color="#fff" size={17}/>
                        </Link>
                      </td>
                    </tr>

                    <tr>
                      <td data-label="Listagem">Mercadorias</td>
                      <td data-label="#">
                        <Link className="action" style={{backgroundColor: '#F6a935'}} to={`/listagem_empresas`}>
                          <FiArrowRight color="#fff" size={17}/>
                        </Link>
                      </td>
                    </tr>

                    <tr>
                      <td data-label="Listagem">Vendas</td>
                      <td data-label="#">
                        <Link className="action" style={{backgroundColor: '#F6a935'}} to={`/listagem_empresas`}>
                          <FiArrowRight color="#fff" size={17}/>
                        </Link>
                      </td>
                    </tr>

                    <tr>
                      <td data-label="Listagem">5 - exemplo</td>
                      <td data-label="#">
                        <Link className="action" style={{backgroundColor: '#F6a935'}} to={`/5valor`}>
                          <FiArrowRight color="#fff" size={17}/>
                        </Link>
                      </td>
                    </tr>

              </tbody>
            </table>
      </div>
    </div>
  )
}