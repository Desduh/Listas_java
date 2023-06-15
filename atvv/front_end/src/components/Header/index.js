import './header.css';
import logo from '../../assets/logo.png';

import { Link } from 'react-router-dom';
import { FiHome, FiPlus, FiArchive, FiClipboard, FiLogOut } from "react-icons/fi";

export default function Header(){

    return(
        <div className="sidebar">
            <div>
                <img src={logo} alt="AutoBot logo"/>
            </div>

            <Link to="/dashboard">
                <FiHome color="#fff" size={25}/> Início
            </Link>

            <Link to="/cadastrar">
                <FiPlus color="#fff" size={25}/> Cadastrar
            </Link>

            <Link to="/produtos">
                <FiArchive color="#fff" size={25}/> Produtos
            </Link>

            <Link to="/">
                <FiLogOut color="#fff" size={25}/> Sair
            </Link>
        </div>
    )
}