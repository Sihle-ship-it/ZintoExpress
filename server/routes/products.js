const express = require('express')
const router = express.Router()

const book_controller = require('../controllers/productsController.js')

router.get('/', book_controller.getProducts);

router.post('/', book_controller.createProducts);

module.exports = router;