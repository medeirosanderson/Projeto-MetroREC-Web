import { useState, type ChangeEvent } from 'react'
import { calcularRota } from '../services/metroService'
import type { Estacao, Rota } from '../types/metro'
import TrajetoVertical from './TrajetoVertical'

interface CalculadoraRotaProps {
estacoes: Estacao[]
origemId: string
destinoId: string
onOrigemChange: (id: string) => void
onDestinoChange: (id: string) => void
}

function CalculadoraRota({
estacoes,
origemId,
destinoId,
onOrigemChange,
onDestinoChange,
}: CalculadoraRotaProps) {
const [rota, setRota] = useState<Rota | null>(null)

const rotaAtual =
    rota &&
    rota.origem.id === Number(origemId) &&
    rota.destino.id === Number(destinoId)
    ? rota
    : null

function handleOrigem(evento: ChangeEvent<HTMLSelectElement>) {
    onOrigemChange(evento.target.value)
}

function handleDestino(evento: ChangeEvent<HTMLSelectElement>) {
    onDestinoChange(evento.target.value)
}

async function handleCalcular() {
    const resultado = await calcularRota(Number(origemId), Number(destinoId))
    setRota(resultado)
}

return (
    <section className="card">
    <h2>Calcular rota</h2>

    <div className="campos">
        <label>
        Origem
        <select value={origemId} onChange={handleOrigem}>
            <option value="">Selecione...</option>
            {estacoes.map((estacao) => (
            <option key={estacao.id} value={estacao.id}>
                {estacao.nome}
            </option>
            ))}
        </select>
        </label>

        <label>
        Destino
        <select value={destinoId} onChange={handleDestino}>
            <option value="">Selecione...</option>
            {estacoes.map((estacao) => (
            <option key={estacao.id} value={estacao.id}>
                {estacao.nome}
            </option>
            ))}
        </select>
        </label>
    </div>

    <button
        className="botao-calcular"
        onClick={handleCalcular}
        disabled={!origemId || !destinoId}
    >
        Calcular rota
    </button>

    {rotaAtual && (
        <div className="resultado">
        <p className="trajeto">
            {rotaAtual.origem.nome} → {rotaAtual.destino.nome}
        </p>

        <div className="numeros">
            <div className="numero">
            <strong>{rotaAtual.distanciaTotal.toFixed(1)} km</strong>
            distância
            </div>
            <div className="numero">
            <strong>{rotaAtual.tempoEstimado} min</strong>
            tempo
            </div>
            <div className="numero">
            <strong>{rotaAtual.caminho.length}</strong>
            estações
            </div>
        </div>

        <TrajetoVertical caminho={rotaAtual.caminho} />
        </div>
    )}
    </section>
)
}

export default CalculadoraRota