db = db.getSiblingDB('mibase');

db.createCollection('Persona');

db.persona.insertMany([
  { nombre: "Juan", direccion: "av9" , telefono: "1234567890"},
  { nombre: "Maria", direccion: "av7" ,telefono: "1234567890"},
  { nombre: "Pedro", direccion: "av10" ,telefono: "1234567890"}
]);