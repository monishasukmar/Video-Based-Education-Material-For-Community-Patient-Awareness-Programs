<%@ Page Title="" Language="vb" AutoEventWireup="false" MasterPageFile="~/Site2.Master" CodeBehind="ViewCourse.aspx.vb" Inherits="WebApplication1.WebForm1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="conMain" runat="server">
     <h3 style="color: blue">View Courses</h3>

    <center>
        <asp:Table ID="Table1" Width="80%" GridLines="Both" runat="server">
            <asp:TableRow runat="server">
                <asp:TableCell runat="server" CssClass="th1">Sno</asp:TableCell>
                <asp:TableCell runat="server" CssClass="th1">Course Code</asp:TableCell>
                <asp:TableCell runat="server" CssClass="th1">Course Name</asp:TableCell>
                <asp:TableCell runat="server" CssClass="th1">Edit</asp:TableCell>
                <asp:TableCell runat="server" CssClass="th1">Delete</asp:TableCell>
            </asp:TableRow>
        </asp:Table>
    </center>
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ContentPlaceHoldelast" runat="server">
</asp:Content>
