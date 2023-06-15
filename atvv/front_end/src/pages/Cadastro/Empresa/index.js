import '../../style.css';
import { useState } from "react";

import Header from '../../../components/Header';
import Title from '../../../components/Title';

import MultiStepProgressBar from "../../../components/MultiStepProgressBar/empresa";

import Pessoal from './Pessoal';
import Endereco from './Endereco';

import { FiBriefcase } from "react-icons/fi";

export default function CadastrarEmpresa() {
  const [page, setPage] = useState("pageone");

  const nextPage = (page) => {
    setPage(page);
  };

  const nextPageNumber = (pageNumber) => {
    switch (pageNumber) {
      case "1":
        setPage("pageone");
        break;
      case "2":
        setPage("pagetwo");
        break;
      default:
        setPage("1");
    }
  };

  return (
    <div>
      <Header />
      <div className="content">
        <Title name="Empresa">
          <FiBriefcase color="#8b8da5" size={25}/>
        </Title>

        <MultiStepProgressBar page={page} />
        {
          {
            pageone: <Pessoal onButtonClick={nextPage} />,
            pagetwo: <Endereco onButtonClick={nextPage} />
          }[page]
        }
      </div>
    </div>
  );
}