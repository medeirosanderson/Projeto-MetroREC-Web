import { useEffect, useState } from 'react'
import CalculadoraRota from './components/CalculadoraRota'
import ListaEstacoes from './components/ListaEstacoes'
import { listarEstacoes } from './services/metroService'
import type { Estacao } from './types/metro'
import silhueta from './assets/silhueta-recife.svg'

function App() {
  const [estacoes, setEstacoes] = useState<Estacao[]>([])
  const [origemId, setOrigemId] = useState('')
  const [destinoId, setDestinoId] = useState('')

  useEffect(() => {
    listarEstacoes().then(setEstacoes)
  }, [])

  return (
    <div className="app">
      <header className="cabecalho">
        <div>
          <p className="eyebrow">PLANEJADOR DE ROTAS</p>
          <h1>Metrô do Recife</h1>
          <p className="subtitulo">
            Escolha onde embarcar e onde descer. A gente mostra o caminho.
          </p>
        </div>
        <img className="silhueta" src={silhueta} alt="" />
      </header>
      <main className="layout">
        <CalculadoraRota
          estacoes={estacoes}
          origemId={origemId}
          destinoId={destinoId}
          onOrigemChange={setOrigemId}
          onDestinoChange={setDestinoId}
        />
        <ListaEstacoes
          estacoes={estacoes}
          onDefinirOrigem={setOrigemId}
          onDefinirDestino={setDestinoId}
        />
      </main>
    </div>
  )
}

export default App