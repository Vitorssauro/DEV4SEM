import User from "@/models/User";
import { NextResponse } from "next/server";
import connectMongo from "@/utils/dbConnect";

export async function POST(request) {
    const data = await request.json();

    // Conecta ao MongoDB
    await connectMongo();

    try {

        const user = await User.create(data);
        return NextResponse.json({ sucess: true, data: user });
    } catch (error) {
        return NextResponse.json({ sucess: false, error: error.message }, { status: 400 });
    }

};