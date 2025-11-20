import {faker} from "@faker-js/faker"

let username= "admin"
let passowrd = "oGUW6iwg3=P="

let Authorization = btoa(`${username}:${passowrd}`)
console.log(Authorization)

let fname = faker.person.firstName()
let Cname = faker.company.buzzNoun()
console.log(fname)
console.log(Cname)