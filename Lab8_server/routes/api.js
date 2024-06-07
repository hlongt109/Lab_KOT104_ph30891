var express = require('express');
var router = express.Router();

// them model
const Movie = require('../models/movies')


// api them movie
router.post('/add-movie', async (req, res) => {
    try {
        const data = req.body;
        const newMovie = new Movie({
            title: data.title,
            releaseDate: data.releaseDate,
            posterUrl: data.posterUrl,
            shotDescription: data.shotDescription,
            genre: data.genre,
            duration: data.duration
        });

        const result = await newMovie.save();
        if (result) {
            res.json({
                "status": 200,
                "messenger": "Add movie successfully",
                "data": result
            })
        } else {
            res.json({
                "status": 400,
                "messenger": "Error, add movie failure",
                "data": []
            })
        }
    } catch (error) {
        console.log("Error: " + error);
    }
});

// get list movie
router.get("/get-list-movies", async (req, res) => {
    try {
        const data = await Movie.find();
        if (data) {
            // const modifiedData = data.map(movie =>({
            //     ...movie.toObject(),
            //     _id: movie._id.toString()
            // }))
            res.status(200).send(data)
            // res.json({
            //     "status": 200,
            //     "messenger": "Get movies list successfully",
            //     "data": modifiedData
            // })
        } else {
            res.json({
                "status": 400,
                "messenger": "Get : Not found",
                "data": []
            })
        }
    } catch (error) {
        console.log("Error: " + error);
    }
})

// xoa mot movie
router.delete('/delete-movie-by-id/:id', async (req, res) => {
    try {
        const { id } = req.params
        const result = await Movie.findByIdAndDelete(id);
        if (result) {
            res.json({
                "status": 200,
                "messenger": "Delete movie successfully",
                "data": result
            })
        } else {
            res.json({
                "status": 400,
                "messenger": "Error, delete movie failure",
                "data": []
            })
        }
    } catch (error) {
        console.log(error);
    }
});
// get one movie
router.get('/get-movie-by-id/:id', async (req, res) => {
    try {
        const { id } = req.params
        const data = await Movie.findById(id);
        // console.log("Found : "+JSON.stringify(data))
        res.status(200).send(data)
    } catch (error) {
        console.log(error);
    }
});
// update movie
// router.put("/update-movie/:id", async(req, res) =>{
//     try {
//         const {id} = req.params
//         const data = req.body;
//         const newData = await Movie.findById(id)
//         let result = null;
//         if(newData){
//             newData.title = data.title ?? newData.title,
//             newData.releaseDate = data.releaseDate ?? newData.releaseDate,
//             newData.posterUrl = data.posterUrl ?? newData.posterUrl,
//             newData.shotDescription = data.shotDescription ?? newData.shotDescription,
//             newData.genre = data.genre ?? newData.genre,
//             newData.duration = data.duration ?? newData.duration,
//             result = await newData.save();
//         }
//         if (result) {
//             res.json({
//                 "status": 200,
//                 "messenger": "Update successfully",
//                 "data": result
//             })
//         } else {
//             res.json({
//                 "status": 400,
//                 "messenger": "Error, Update failure",
//                 "data": []
//             })
//         }
//     } catch (error) {
//         console.log(error);
//     }
// })
router.put("/update-movie", async (req, res) => {
    try {
        const { id, title, releaseDate, posterUrl, shotDescription, genre, duration } = req.body;
        if (!id) {
            return res.status(400).json({
                status: 400,
                message: "Error, ID is required",
                data: []
            });
        }
        const movie = await Movie.findById(id);
        if (!movie) {
            return res.status(404).json({
                status: 404,
                message: "Movie not found",
                data: []
            });
        }
        
        movie.title = title ?? movie.title;
        movie.releaseDate = releaseDate ?? movie.releaseDate;
        movie.posterUrl = posterUrl ?? movie.posterUrl;
        movie.shotDescription = shotDescription ?? movie.shotDescription;
        movie.genre = genre ?? movie.genre;
        movie.duration = duration ?? movie.duration;
        
        const result = await movie.save();
        res.json({
            status: 200,
            message: "Update successfully",
            data: result
        });
    } catch (error) {
        console.log(error);
        res.status(500).json({
            status: 500,
            message: "Error, Update failure",
            data: []
        });
    }
});
// add movie with image
const Upload = require('../config/common/upload');
router.post('/add-movie-with-file-image', Upload.array('image', 5), async (req, res) => {

    try {
        const data = req.body; // lay du lieu tu body
        const { files } = req  // files neu upload nhieu, file neu up load 1 anh
        const urlsImage = files.map((file) => `${req.protocol}://${req.get("host")}/uploads/${file.filename}`)
        // url anh se duoc luu duoi dang : http://localhost:3000/upload/filename
        const newMovie = new Movie({
            title: data.title,
            releaseDate: data.releaseDate,
            posterUrl: urlsImage,
            shotDescription: data.shotDescription,
            genre: data.genre,
            duration: data.duration
        });
        const result = await newMovie.save(); // them vao database
        if (result) {
            res.json({
                "status": 200,
                "messenger": "Add movie successfully",
                "data": result
            })
        } else {
            res.json({
                "status": 400,
                "messenger": "Error, add movie failure",
                "data": []
            })
        }
    } catch (error) {
        console.log(error);
    }
});
// update movie 
router.put('/update-movie-by-id/:id', Upload.array('image', 5), async (req, res) => {
    try {
        const { id } = req.params
        const data = req.body;
        const { files } = req;

        let urlImg;
        const updateMovie = await Movie.findById(id)
        if (files && files.length > 0) {
            urlImg = files.map((file) => `${req.protocol}://${req.get("host")}/uploads/${file.filename}`);

        }
        if (urlImg == null) {
            urlImg = updateMovie.image;
        }

        let result = null;
        if (updateMovie) {
                updateMovie.title = data.title ?? updateMovie.title,
                updateMovie.releaseDate = data.releaseDate ?? updateMovie.releaseDate,
                updateMovie.posterUrl = urlImg,
                updateMovie.shotDescription = data.shotDescription ?? updateMovie.shotDescription,
                updateMovie.genre = data.genre ?? updateMovie.genre,
                updateMovie.duration = data.duration ?? updateMovie.duration

                result = await updateMovie.save();
        }
        if (result) {
            res.json({
                'status': 200,
                'messenger': 'Update movie successfully',
                'data': result
            })
        } else {
            res.json({
                'status': 400,
                'messenger': 'Update movie failure',
                'data': []
            })
        }
    } catch (error) {
        console.log(error);
    }
})

module.exports = router;