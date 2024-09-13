import { getTask, createTask } from "@/controllers/TaskController";
import { NextResponse } from "next/server";


export async function GET() {
    try {
        const tasks = await getTask();
        return NextResponse.json({
            success: true,
            data: tasks
        });
    } catch (error) {
        console.error(error, "Route");
        return NextResponse.json(
            { success: false },
            { status: 400 }
        );
    }
}


export async function POST(request) {
    try {
        const data = await request.json();
        const task = await createTask(data);
        return NextResponse.json({
            success: true,
            data: task
        })
    } catch (error) {
        console.error(error, "Route");
        return NextResponse.json(
            { success: false },
            { status: 400 }
        );
    }

}
