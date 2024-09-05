import mongoose from "mongoose";

const DATABASE_URL = process.env.DATABASE_URL;

// verificação
if (!DATABASE_URL) {
    throw new Error(
        'Por favor, dafina a variável DATABASE_URL no arquivo .env.local'
    )
}

const connectMongo = async () => {

    mongoose.connect(DATABASE_URL)
        .then("Conctado com Mongo")
        .catch(err => console.error(err));

}

export default connectMongo;