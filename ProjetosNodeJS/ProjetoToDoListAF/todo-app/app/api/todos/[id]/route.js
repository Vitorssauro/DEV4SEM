import { updateTodo, deleteTodo } from '@/controllers/TodoController';
import { NextResponse } from 'next/server';

// put
export async function PUT(req, { params }) {
  try {
    const data = await req.json();
    const todo = await updateTodo(params.id, data);
    if (!todo) {
      return NextResponse.json({ success: false }, { status: 400 });
    }
    return NextResponse.json({ success: true, data: todo });
  } catch (error) {
    return NextResponse.json({ success: false }, { status: 400 });
  }
}

// delete
export async function DELETE(req, { params }) {
  try {
    const todo = await deleteTodo(params.id);
    if (!todo) {
      return NextResponse.json({ success: false }, { status: 400 });
    }
    return NextResponse.json({ success: true, data: todo });
  } catch (error) {
    return NextResponse.json({ success: false }, { status: 400 });
  }
}