import type { Estacao } from '../types/metro'

interface TrajetoVerticalProps {
caminho: Estacao[]
}

function TrajetoVertical({ caminho }: TrajetoVerticalProps) {
const ultimo = caminho.length - 1

return (
    <ol className="trilha">
    {caminho.map((estacao, indice) => {
        const extremo = indice === 0 || indice === ultimo

        return (
        <li
            key={estacao.id}
            className={extremo ? 'trilha-extremo' : undefined}
        >
            {estacao.nome}
        </li>
        )
    })}
    </ol>
)
}

export default TrajetoVertical