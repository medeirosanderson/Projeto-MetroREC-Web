export interface Estacao {
    id: number
    nome: string
    linha: string
}

export interface Rota {
    origem: Estacao
    destino: Estacao
    caminho: Estacao[]
    distanciaTotal: number
    tempoEstimado: number
}