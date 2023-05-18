const express = require("express")
const path = require("path")

const app = express()

app.use(express.static(path.join(__dirname, "public")))


app.listen(3000, () => {
    console.log("Seu website está sendo hospedado em http://localhost:3000")
})