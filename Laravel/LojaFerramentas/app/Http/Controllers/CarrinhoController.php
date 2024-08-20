<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Produto;
use Illuminate\Support\Facades\Auth;

class CarrinhoController extends Controller
{
    public function add(Request $request, Produto $produto){
        $dados = $request->validate([
            'quantidade'=>'required|numeric|min:1'
        ]);
        Produto::create([
            'id.produto'=>$produto->id,
            'id.user'=>Auth::id(),
            'quantidade'=>$request->quantidade
        ]);
        return redirect()->route('produtos.show')
        ->with('sucesso','Produto adicionado ao Carrinho!');
    }
}