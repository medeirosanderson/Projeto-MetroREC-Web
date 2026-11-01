import { useState, type ChangeEvent } from 'react'
import type { Estacao } from '../types/metro'

interface ListaEstacoesProps {
estacoes: Estacao[]
onDefinirOrigem: (id: string) => void
onDefinirDestino: (id: string) => void
}

function normalizar(texto: string): string {
return texto
    .normalize('NFD')
    .replace(/[\u0300-\u036f]/g, '')
    .toLowerCase()
}

function ListaEstacoes({
estacoes,
onDefinirOrigem,
onDefinirDestino,
}: ListaEstacoesProps) {
const [busca, setBusca] = useState('')
const [linhaSelecionada, setLinhaSelecionada] = useState('Todas')

const linhas = ['Todas', ...new Set(estacoes.map((estacao) => estacao.linha))]

const estacoesFiltradas = estacoes.filter((estacao) => {
    const combinaNome = normalizar(estacao.nome).includes(normalizar(busca))
    const combinaLinha =
    linhaSelecionada === 'Todas' || estacao.linha === linhaSelecionada
    return combinaNome && combinaLinha
})

function handleBusca(evento: ChangeEvent<HTMLInputElement>) {
    setBusca(evento.target.value)
}

return (
    <section className="card">
    <h2>Estações</h2>

    <div className="linha-busca">
        <input
        type="text"
        placeholder="Buscar estação..."
        value={busca}
        onChange={handleBusca}
        />
        {busca && (
        <button className="botao-secundario" onClick={() => setBusca('')}>
            Limpar
        </button>
        )}
    </div>

    <div className="filtros">
        {linhas.map((linha) => (
        <button
            key={linha}
            onClick={() => setLinhaSelecionada(linha)}
            disabled={linha === linhaSelecionada}
        >
            {linha}
        </button>
        ))}
    </div>

    <p className="contador">
        Mostrando {estacoesFiltradas.length} de {estacoes.length}
    </p>

    {estacoesFiltradas.length === 0 ? (
        <p>Nenhuma estação encontrada.</p>
    ) : (
        <ul className="estacoes-lista">
        {estacoesFiltradas.map((estacao) => (
            <li key={estacao.id}>
            <span>{estacao.nome}</span>
            <div className="item-acoes">
                <span className={`badge badge-${estacao.linha.toLowerCase()}`}>
                {estacao.linha}
                </span>
                <button
                className="botao-mini"
                onClick={() => onDefinirOrigem(String(estacao.id))}
                >
                Origem
                </button>
                <button
                className="botao-mini"
                onClick={() => onDefinirDestino(String(estacao.id))}
                >
                Destino
                </button>
            </div>
            </li>
        ))}
        </ul>
    )}
    </section>
)
}

export default ListaEstacoes