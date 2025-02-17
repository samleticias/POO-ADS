class Professor {
    name : string = "Ely";
    payment : number = 120.56;
    preferredLanguage : string = "TypeScript";
}

function main(){
    var professor = new Professor;
    
    console.log(`${professor.name}\nMy payment time is ${professor.payment}\nand\nmy preffered language is ${professor.preferredLanguage}`);
}

main();
