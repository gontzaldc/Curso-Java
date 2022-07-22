import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

import './App.css';
import Cabecera from './cabecera';
import Carrousel from './carrouse';

function App() {
  const styleCarrousel={
    heigth:"20px",
  }
  return (
    <div className="App">
      <Cabecera />
      <Carrousel />
      <div className="card" style={{ width: "18rem" }}>
        <img src="/logo192.png" className="card-img-top" alt="..."></img>
        <div className="card-body">
          <h5 className="card-title">Card title</h5>
          <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          <a href="#" className="btn btn-primary">Go somewhere</a>
        </div>
      </div>
    </div>
  );
}

export default App;
