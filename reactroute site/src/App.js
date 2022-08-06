import {Routes, Route} from 'react-router-dom';
import Contact from './components/Contact';
import Home from './components/Home';
import About from './components/About';
import Content from './components/Content';

function App() {
  return (
      <Routes>
        <Route path="/" element={<Home/>}></Route>
        <Route path="content" element={<Content/>}></Route>
        <Route path="about" element={<About/>}></Route>
        <Route path="contact" element={<Contact/>}></Route>
      </Routes>
  );
}

export default App;
