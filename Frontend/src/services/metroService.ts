import type { Estacao, Rota } from '../types/metro'

const BASE_URL = '/api'

async function buscar<T>(caminho: string): Promise<T> {
    const resposta = await fetch(`${BASE_URL}${caminho}`)

    if (!resposta.ok) {
    throw new Error(`Erro ${resposta.status} ao acessar ${caminho}`)
    }

    return resposta.json()
}

export function listarEstacoes(): Promise<Estacao[]> {
    return buscar<Estacao[]>('/estacoes')
}

export function buscarEstacoesPorLinha(linha: string): Promise<Estacao[]> {
    return buscar<Estacao[]>(`/estacoes/linha?linha=${encodeURIComponent(linha)}`)
}

export function buscarEstacoesPorNome(nome: string): Promise<Estacao[]> {
    return buscar<Estacao[]>(`/estacoes/estacao?nome=${encodeURIComponent(nome)}`)
}

export function calcularRota(origem: number, destino: number): Promise<Rota> {
    return buscar<Rota>(`/rotas?origem=${origem}&destino=${destino}`)
}