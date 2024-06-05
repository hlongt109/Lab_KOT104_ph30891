const mongoose = require('mongoose');
const Scheme = mongoose.Schema;

const Movie = new Scheme({
    title: {type: String, maxLength: 255},
    releaseDate: {type: String},
    posterUrl: {type: String},
    shotDescription: {type: String},
    genre: {type: String},
    duration: {type: String}
},{
    timestamps: true
})
module.exports = mongoose.model("movie",Movie);
