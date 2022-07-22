import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

export default function carrousel() {
    return (
        <div id="carousel-example-1" className="carousel slide carousel-fade" data-ride="carousel" data-interval="false">

            <ol className="carousel-indicators">
                <li data-target="#carousel-example-1" data-slide-to="0" className="active"></li>
                <li data-target="#carousel-example-1" data-slide-to="1"></li>
                <li data-target="#carousel-example-1" data-slide-to="2"></li>
            </ol>
            <div className="carousel-inner" role="listbox">

                <div className="carousel-item active">
                    <div className="view">
                        <div className="full-bg-img flex-center mask rgba-indigo-light white-text">
                            <ul className="animated fadeInUp col-md-12 list-unstyled list-inline">
                                <li>
                                    <h1 className="font-weight-bold text-uppercase">Material Design for Bootstrap 4</h1>
                                </li>
                                <li>
                                    <p className="font-weight-bold text-uppercase py-4">The most powerful and free UI KIT for Bootstrap</p>
                                </li>
                                <li className="list-inline-item">
                                    <a target="_blank" href="https://mdbootstrap.com/getting-started/" className="btn btn-unique btn-lg btn-rounded mr-0">Sign up!</a>
                                </li>
                                <li className="list-inline-item">
                                    <a target="_blank" href="https://mdbootstrap.com/material-design-for-bootstrap/" className="btn btn-cyan btn-lg btn-rounded ml-0">Learn more</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div className="carousel-item">
                    <div className="view">
                        <div className="full-bg-img flex-center mask rgba-purple-light white-text">
                            <ul className="animated fadeInUp col-md-12 list-unstyled">
                                <li>
                                    <h1 className="font-weight-bold text-uppercase">Lots of tutorials at your disposal</h1>
                                </li>
                                <li>
                                    <p className="font-weight-bold text-uppercase py-4">And all of them are FREE!</p>
                                </li>
                                <li>
                                    <a target="_blank" href="https://mdbootstrap.com/bootstrap-tutorial/" className="btn btn-primary btn-rounded btn-lg">Start learning</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div className="carousel-item">
                    <div className="view">
                        <div className="full-bg-img flex-center mask rgba-blue-light white-text">
                            <ul className="animated fadeInUp col-md-12 list-unstyled">
                                <li>
                                    <h1 className="font-weight-bold text-uppercase">Visit our support forum</h1></li>
                                <li>
                                    <p className="font-weight-bold text-uppercase py-4">Our community can help you with any question</p>
                                </li>
                                <li>
                                    <a target="_blank" href="https://mdbootstrap.com/forums/forum/support/" className="btn btn-lg btn-indigo btn-rounded">Support forum</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
            <a className="carousel-control-prev" href="#carousel-example-1" role="button" data-slide="prev">
                <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                <span className="sr-only">Previous</span>
            </a>
            <a className="carousel-control-next" href="#carousel-example-1" role="button" data-slide="next">
                <span className="carousel-control-next-icon" aria-hidden="true"></span>
                <span className="sr-only">Next</span>
            </a>
        </div>
    )
}