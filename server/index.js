const express = require('express')
const app = express()
const bodyParser = require('body-parser');
const cors = require('cors');
const port =  3000
const products_routes = require('./routes/products.js')



app.listen(port,
    (error) =>{
       if(!error)
           console.log(`Server is on Port ${ port } Crtl + C to Stop`)
       else {
           console.log("Error occurred, server can't start", error);
       }
   });
 

app.use(express.json())
app.use('/api/products', products_routes)



