import { BrowserRouter as Router } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import RoutesApp from './routes'

export default function App() {
    return (
        <Router>
            <ToastContainer autoClose={2000} />
            <RoutesApp />
        </Router>
    );
}