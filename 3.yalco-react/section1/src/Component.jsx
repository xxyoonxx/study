import React, { Component } from 'react';

class ClassComp extends Component {
    render() {
        return <p>Class Comp</p>;
    }
}

function FunctionComp() {
    return <p>Function Comp</p>;
}

const ArrowFunctionCompt = () => {
    return <p>Arrow Function Comp</p>;
};

export { ClassComp, FunctionComp, ArrowFunctionCompt };