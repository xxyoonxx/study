import '../App.css'

import InfoCard from './InfoCard.jsx'
import ProductCard from './ProductCard.jsx';
import CardLayout from './CardLayout.jsx';
import withConditionalCard from './withConditionalCard.jsx';
import SimpleCard from './SimpleCard.jsx';

const cards = [
    {
        idx: 1,
        title: "Props in React",
        content: "Props pass data from one component to another.",
        author: "Alice"
    }, {
        idx: 2,
        title: "React Composition",
        content: "Composition makes your components more reusable"
    }
]

const product = {
    name: "Laptop",
    price: 123.4567
}

const ConditionalSimpleCard = withConditionalCard(SimpleCard)

function PropsApp() {
    return (
        <div style={{display:'flex', gap:'2rem'}}>
            <ProductCard {...product} formatPrice={(p) => `$${p.toFixed(2)}`}/>
            <div>
                {cards.map(cardData => (
                    <InfoCard key={cardData.idx} {...cardData}/>
                ))}
            </div>
            <CardLayout title="About">
                <p>Props of Components</p>
            </CardLayout>

            <CardLayout title="Details">
                <ul>
                    <li>Feature A</li>
                    <li>Feature B</li>
                    <li>Feature C</li>
                </ul>
            </CardLayout>
            <CardLayout title="Contact">
                <p>Email: example@example.com</p>
                <p>Phone: 123-456-7890</p>
            </CardLayout>
            <ConditionalSimpleCard
                title="Active Card"
                content="This card is active."
                disabled={false}
            />

            <ConditionalSimpleCard
                title="Disabled Card"
                content="This card is disabled."
                disabled={true}
            />
        </div>
    )
}

export default PropsApp